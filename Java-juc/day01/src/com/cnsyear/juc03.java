package com.cnsyear;

/**
 * volatile关键字
 * 
 * 解决方法二：volatile 
 * @author jiebaobao
 *
 */
public class juc03 {

	/**
	 * Main线程
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread3 td = new MyThread3();
		new Thread(td).start();//开启一个子线程执行写的操作
		
		
		while(true) {
				if(td.isFlag()) {
					System.out.println("Main线程执行==="+td.isFlag());
					break;
				}
		}
				
	}

}


/**
 * 定义一个线程
 * 
 * @author jiebaobao
 *
 */
class MyThread3 implements Runnable {
	private volatile boolean flag = false;// 一个变量默认false

	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//这里执行写的操作
		flag = true;
		System.out.println("线程一执行==="+flag);
	}
	

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}

