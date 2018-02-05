package com.me2me.ims.base;

/**
 * 路径相关工具类，包含路径匹配等功能。
 * 
 * @author Gene
 * 
 */
public class PathUtils {
	/**
	 * 文件目录匹配。
	 * Ant 风格的目录模糊匹配，支持**，*。<br>**代表任意级目录<br>*代表某一级目录。<br>
	 * 如 /amdin/?/b
	 * @date 2014-5-14
	 * @author jiwei.zhang
	 * @param pattern
	 * @param target
	 * @return
	 */
	public static boolean fuzzyPathMatch(String pattern,String target){
		
		// 处理例外,直接返回true
		String [] excludes = {"/**","/**/","/**/*","*.*"};
		for(String p:excludes){
			if(p.equals(pattern)){
				return true;
			}
		}
		
		
		// 处理文件名
		int pos = target.lastIndexOf("/");
		String fileName = target.substring(pos + 1);
		String filePath = target.substring(0, pos+1);
		
		// 处理映射路径
		pos = pattern.lastIndexOf("/");
		String filePattern = pattern.substring(pos + 1);
		String filePathPattern = pattern.substring(0, pos+1);
		
		// 验证文件名
		if(fuzzyFileMatch(filePattern, fileName)){
			// 验证目录。
			return fuzzyPathMatch2(filePathPattern, filePath);
		}
		return false;
	}
	/**
	 * Ant 风格的目录模糊匹配，支持**，*。<br>**代表任意级目录<br>*代表某一级目录。
	 * @param pattern 表达式。如 1.html
	 * @param target 待匹配的字符串路径。如/abc/s/eee/1.html
	 * @return
	 */
	private static boolean fuzzyPathMatch2(String pattern,String target){
		pattern = pattern.replaceFirst("^/", "");
		target = target.replaceFirst("^/", "");
		
		if(ValidateUtils.isEmpty(target) && pattern.matches(".*\\w+.*")) return false;
		
			// 判断根目录/
			if(target.equals("/") && pattern.startsWith("/**")){
				return true;
			}
			
			String[] patternPart = pattern.split("/");
			String[] targetPart = target.split("/");
			int targetPos =0,patternPos=0;
			while(patternPos<patternPart.length){
				if(targetPos==targetPart.length){	// 待匹配字符串 比表达式长
					// 找到下一个pattern
					while(patternPos<patternPart.length){
						String pStr = patternPart[patternPos];
						if(pStr.matches("^\\*+$")){
							patternPos++;
						}else{
							return false;
						}
					}
					return true;
				}
				String pStr =patternPart[patternPos];
				String tStr =targetPart[targetPos];
				if(targetPos>targetPart.length-1){
					if(!pStr.equals("**")){
						return false;		// 如果目标字符串搜索的当前位置大于其长度，则匹配失败。
					}
				}
				if(pStr.equals("*")){		// 匹配任意一级目录。
					targetPos ++;
					patternPos ++;
					continue;
				}else if(patternPart[patternPos].equals("**")){		// 匹配多级目录。以下级目录作为结束点。
					if(patternPos==patternPart.length-1){		// 如果最后一级是/**，会匹配所有的目录。
						return true;
					}
					// 找到下一个pattern
					while(patternPos<patternPart.length){
						pStr = patternPart[patternPos];
						if(pStr.matches("^\\*+$")){  // 如果表达式位是**，则找到最后一次非**的位置，避免/**/**的情况。
							patternPos++;
						}else{
							break;
						}
						return true;		//剩下的都是**
					}
					// 从当前位置向下匹配，找到第一个匹配下一个pettern的路径。
					
					boolean isContain= false;
					while(targetPos<targetPart.length){// 计算目标字符串的匹配位置。
						tStr = targetPart[targetPos];
						if(fuzzyFileMatch(pStr, tStr)){
							isContain =true;
							break;
						}
						targetPos ++;
					}
					if(!isContain){		// 如果在*号后面的字符，没有在目标字符串中找到，则返回false。
						return false;
					}
				}else{		// 常规模糊路径比较，如果遇到字符不一致，则立即返回。
					if(!fuzzyFileMatch(patternPart[patternPos],targetPart[targetPos])){		
						return false;
					}
					targetPos ++;
					patternPos ++;
				}
			}
			
			if(targetPos<targetPart.length){		// 如果表达式已经搜索完成，但是目标字符串搜索未完成，则失败，类似这样的情况: a*c,aacde。
				return false;
			}else{
				return true;
			}
			
	}
	/**
	 * 模糊匹配，可使用*?，*代表0个或多个字符，?代表一个字符。
	 * @param pattern 搜索表达式。如a*bds
	 * @param target 目标字符串。如absd
	 * @return 如果匹配则返回true,否则返回false;
	 */
	public static boolean fuzzyFileMatch(String pattern,String target){
		if(!pattern.contains("*") && !pattern.contains("?")){		// 常规匹配。
			return pattern.equals(target);
		}
		int pLen = pattern.length();
		int tLen = target.length();
		int curPPos = 0;		// 当前表达式搜索位置
		int posTPos = 0;		// 当前目标字符串搜索位置
		if(pattern.equals("*")) return true;
		for (; curPPos < pLen;curPPos++) {
			if(posTPos>tLen-1) return false;		// 如果目标字符串搜索的当前位置大于其长度，则匹配失败。
			char curPChar = pattern.charAt(curPPos);		// 当前表达式字符。
			char curTChar = target.charAt(posTPos);			// 当前目标字符串字符。
			if(curPChar=='?'){		//如果是?号忽略本次比较，即?号可取任意值。
				
			}else if (curPChar == '*') {
				if(curPPos==pLen-1){		// 如果表达式的最后一位是* ,返回真，类似 abc*。
					return true;
				}
				char nextChar=0;
				for(int j=curPPos;j<pLen-1;j++){		// 如果表达式位是*，则找到最后一次*号的位置，避免**的情况。
					nextChar = pattern.charAt(j+1);
					if(nextChar!='*') break;
					curPPos++;
				}
				posTPos = target.indexOf(nextChar,posTPos);		// 计算目标字符串的匹配位置。
				if(posTPos==-1){		// 如果在*号后面的字符，没有在目标字符串中找到，则返回false。
					return false;
				}else{
					continue;
				}
			}else{
				if(curPChar!=curTChar){		// 中途常规比较，如果遇到字符不一致，则立即返回。
					return false;
				}
			}
			posTPos++;		//目标字符串当前搜索位置前进一位
		}
		if(posTPos<tLen){		// 如果表达式已经搜索完成，但是目标字符串搜索未完成，则失败，类似这样的情况: a*c,aacde。
			return false;
		}else{
			return true;
		}
	}
	
	public static void main1(String[] args) {
		boolean t = fuzzyPathMatch("/**/*.html", "/d/d.html");
		System.out.println(t);
	}
	/**
	 * 取相对路径的绝对位置
	 * @date 2014-9-9
	 * @author jiwei.zhang
	 * @param basePath 根目录位置
	 * @param releativePath 相对于根目录的位置，支持./../
	 * @return
	 */
	public static String getAbsFilePath(String basePath,String releativePath){
		basePath= basePath.replace("\\", "/");
		String[] basePaths = basePath.split("/");
		releativePath= releativePath.replace("\\", "/");
		String[] relPaths = releativePath.split("/");
		int posB=basePaths.length,posR=0;
		for(int i=0;i<relPaths.length;i++){
			if(relPaths[i].equals(".")){
				posR++;
			}else if(relPaths[i].equals("..")){
				posR++;
				posB--;
			}
		}
		String path = "";
		for(int i=0;i<posB;i++){
			path+="/"+basePaths[i];
		}
		for(int i=posR;i<relPaths.length;i++){
			path+="/"+relPaths[i];
		}
		
		return path.replace("//", "/");
	}
	public static void main(String[] args) {
		String b ="/a/b/c/";
		String r ="/d/e/f.html";
		b="/**";
		r="/member/aa/bb/cc/d/d";
		System.out.println(fuzzyPathMatch(b, r));
	}

}
