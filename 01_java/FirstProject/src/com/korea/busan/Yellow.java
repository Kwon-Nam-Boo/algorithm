package com.korea.busan;

import com.korea.seoul.Red;

public class Yellow extends Red{
	void test() {
		Yellow y = new Yellow();
		System.out.println(y.a);
		System.out.println(y.b);	// 다른 패키지지만 상속관계라 사용가능
	}

}
