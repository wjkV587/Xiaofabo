package com.caseaction;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String e="对形式有瑕疵的欠条或收条，结合其他证据认定；对现金交付的借贷根据交付凭证、支付能力、交易习惯、借贷金额的大小、当事人间关系以及当事人陈述的交易细节经过等因素综合判断.";
		String regex = "(.{12})";
		e=e.replaceAll (regex, "$1\n");
		
		System.out.println(e);

	}

}
