package com.caseaction;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String e="����ʽ��覴õ�Ƿ�����������������֤���϶������ֽ𽻸��Ľ�����ݽ���ƾ֤��֧������������ϰ�ߡ�������Ĵ�С�������˼��ϵ�Լ������˳����Ľ���ϸ�ھ����������ۺ��ж�.";
		String regex = "(.{12})";
		e=e.replaceAll (regex, "$1\n");
		
		System.out.println(e);

	}

}
