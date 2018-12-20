package com.jeryzhang.common.module_utils.util;

import com.jeryzhang.common.module_utils.BuildConfig;

public class Log {
    private final static String DEFAULT_TAG="xiaokaxiu";
	/**
	 * 错误日志级别常量
	 */
	public final static int LEVEL_ERROR=0;
	/**
	 * 警告日志级别常量
	 */
	public final static int LEVEL_WARING=1;
	
	/**
	 * 调试日志级别常量
	 */
	public final static int LEVEL_DEBUG=2;
	
	/**
	 * 信息日志级别常量
	 */
	public final static int LEVEL_INFO=3;

    /**
     * 是否开始服务日志
     */
    public static boolean canLog = BuildConfig.DEBUG;

    /**
     * 服务日志级别
     */
    public static int logLevel=LEVEL_ERROR;


    public static void i(String msg){
        if(Log.canLog){
            if(Log.logLevel<=Log.LEVEL_INFO){
                android.util.Log.i(DEFAULT_TAG, msg);
            }
        }
    }
    public static void e(String msg){
        if(Log.canLog){
            if(Log.logLevel<=Log.LEVEL_ERROR){
                android.util.Log.e(DEFAULT_TAG, msg);
            }
        }
    }
    public static void e(Throwable tr){
        if(Log.canLog){
            if(Log.logLevel<=Log.LEVEL_ERROR){
                android.util.Log.e(DEFAULT_TAG,"", tr);
            }
        }
    }
    public static void d(String msg){
        if(Log.canLog){
            if(Log.logLevel<=Log.LEVEL_DEBUG){
                android.util.Log.d(DEFAULT_TAG, msg);
            }
        }
    }
    public static void w(String msg){
        if(Log.canLog){
            if(Log.logLevel<=Log.LEVEL_WARING){
                android.util.Log.w(DEFAULT_TAG, msg);
            }
        }
    }
    public static void e(String msg, Throwable tr){
        if(Log.canLog){
            if(Log.logLevel<=Log.LEVEL_ERROR){
                android.util.Log.w(DEFAULT_TAG, msg);
            }
        }
    }

	public static void i(String tag,String msg){
		if(Log.canLog){
			if(Log.logLevel<=Log.LEVEL_INFO){
				android.util.Log.i(tag, msg);
			}
		}
	}
	public static void e(String tag,String msg){
		if(Log.canLog){
			if(Log.logLevel<=Log.LEVEL_ERROR){
				android.util.Log.e(tag, msg);
			}
		}
	}
	public static void d(String tag,String msg){
		if(Log.canLog){
			if(Log.logLevel<=Log.LEVEL_DEBUG){
				android.util.Log.d(tag, msg);
			}
		}
	}
	public static void w(String tag,String msg){
		if(Log.canLog){
			if(Log.logLevel<=Log.LEVEL_WARING){
				android.util.Log.w(tag, msg);
			}
		}
	}
	public static void e(String tag, String msg, Throwable tr){
		if(Log.canLog){
			if(Log.logLevel<=Log.LEVEL_ERROR){
				android.util.Log.w(tag, msg);
			}
		}
	}
    public static void info(String msg){
        i(msg);
    }
	public static void setDebug(boolean debug){
		canLog=debug;
	}
    public static void error(String msg){
        e(msg);
    }
    public static void debug(String msg){
        d(msg);
    }
    public static void waring(String msg){
        w(msg);
    }
    public static void error(String msg, Throwable tr){
        e(msg,tr);
    }


    public static void info(String tag,String msg){
		i(tag,msg);
	}
	public static void error(String tag,String msg){
		e(tag,msg);
	}
	public static void debug(String tag,String msg){
		d(tag,msg);
	}
	public static void waring(String tag,String msg){
		w(tag,msg);
	}
	public static void error(String tag, String msg, Throwable tr){
		e(tag,msg,tr);
	}

}
