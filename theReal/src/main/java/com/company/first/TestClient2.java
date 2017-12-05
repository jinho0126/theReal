package com.company.first;

import java.io.*;
import java.net.*;

class TestData {

	byte[] IUD = new byte[4]; // 0.I(insert) 1.U(update 2.D(delete)
	byte[] GM_TR = new byte[8]; // GMSH0001
	byte[] gubn = new byte[4]; // 0.���嵿�� 1.����Ʈ
	byte[] subg = new byte[4]; // ���α���
	byte[] date = new byte[8]; // �Է�����(KEY)
	byte[] seqn = new byte[8]; // �Ϸù�ȣ(=�Է½ð�)
	byte[] dept = new byte[20]; // �Էºμ�
	byte[] iemp = new byte[20]; // �Է���
	byte[] cod2 = new byte[12]; // �����ڵ�
	byte[] title = new byte[80]; // ����
	byte[] sour = new byte[20]; // �ڷ�������
	byte[] html = new byte[128]; // HTML PATH
	byte[] sugg = new byte[80]; // �ǰ�

	// ����Ʈ ������
	public TestData() {
	}

	// ���������Ͱ����� �ʱ�ȭ ������
	public TestData(String IUD, String GM_TR, String gubn, String subg, String date, String seqn, String dept,
			String iemp, String cod2, String title, String sour, String html, String sugg)
					throws UnsupportedEncodingException {

		setData(this.IUD, IUD);
		setData(this.GM_TR, GM_TR);
		setData(this.gubn, gubn);
		setData(this.subg, subg);
		setData(this.date, date);
		setData(this.seqn, seqn);
		setData(this.dept, dept);
		setData(this.iemp, iemp);
		setData(this.cod2, cod2);
		setData(this.title, title);
		setData(this.sour, sour);
		setData(this.html, html);
		setData(this.sugg, sugg);

	}

	/** �ʵ尪���� �����ϰ� ��迭�� �������� ä���. */
	public void setData(byte[] arryByte, String str) throws UnsupportedEncodingException {

		// ���ڿ� ���� ���̸� ���� �������� ä��� ����
		if (str == null) {
			str = "";
		}

		// �ʵ忡 ä�� ���ڿ��� ����Ʈ�迭�� ��ȯ
		byte[] bytes = str.getBytes("EUC_KR");

		// ���������� ���� ����Ʈ�迭����
		int endIdx = 0;

		// ���������� ����Ʈ�迭 ����
		if (arryByte.length >= bytes.length) {
			endIdx = bytes.length; // �ʵ��� �迭�� ���������͹迭���� ũ�ų� ���� ���
		} else {
			endIdx = arryByte.length; // �ʵ��� �迭�� ���������͹迭���� ���� ���
		}

		// �ʵ�迭�� ���������͹迭������ ä���.
		for (int i = 0; i < endIdx; i++) {
			arryByte[i] = bytes[i];
		}
		// ���������Ͱ��� ä������ ���� �迭�� �������� ä���.
		for (int j = endIdx; j < arryByte.length; j++) {
			arryByte[j] = ' ';
		}
	}

	public String getData(byte[] arryByte) throws UnsupportedEncodingException {

		if (arryByte == null) {
			return "";
		}

		return new String(arryByte, "EUC-KR");

	}

	public void writeDataExternal(java.io.DataOutputStream stream) throws IOException {

		stream.write(IUD);
		stream.write(GM_TR);
		stream.write(gubn);
		stream.write(subg);
		stream.write(date);
		stream.write(seqn);
		stream.write(dept);
		stream.write(iemp);
		stream.write(cod2);
		stream.write(title);
		stream.write(sour);
		stream.write(html);
		stream.write(sugg);
	}

	public void readDataExternal(java.io.DataInputStream stream) throws IOException {

		stream.read(IUD, 0, IUD.length);
		stream.read(GM_TR, 0, GM_TR.length);
		stream.read(gubn, 0, gubn.length);
		stream.read(subg, 0, subg.length);
		stream.read(date, 0, date.length);
		stream.read(seqn, 0, seqn.length);
		stream.read(dept, 0, dept.length);
		stream.read(iemp, 0, iemp.length);
		stream.read(cod2, 0, cod2.length);
		stream.read(title, 0, title.length);
		stream.read(sour, 0, sour.length);
		stream.read(html, 0, html.length);
		stream.read(sugg, 0, sugg.length);
	}

	public void print() throws IOException {

		System.out.println("IDU: " + getData(IUD) + "\tSize:" + IUD.length);
		System.out.println("GM_TR: " + getData(GM_TR) + "\tSize:" + GM_TR.length);
		System.out.println("gubn: " + getData(gubn) + "\tSize:" + gubn.length);
		System.out.println("subg: " + getData(subg) + "\tSize:" + subg.length);
		System.out.println("date: " + getData(date) + "\tSize:" + date.length);
		System.out.println("seqn: " + getData(seqn) + "\tSize:" + seqn.length);
		System.out.println("dept: " + getData(dept) + "\tSize:" + dept.length);
		System.out.println("iemp: " + getData(iemp) + "\tSize:" + iemp.length);
		System.out.println("cod2: " + getData(cod2) + "\tSize:" + cod2.length);
		System.out.println("title: " + getData(title) + "\tSize:" + title.length);
		System.out.println("sour: " + getData(sour) + "\tSize:" + sour.length);
		System.out.println("html: " + getData(html) + "\tSize:" + html.length);
		System.out.println("sugg: " + getData(sugg) + "\tSize:" + sugg.length);

	}

}

class TestClient2 {
	public static void usage() {
		System.out.println("\nUsage : java TestClient server port");
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			usage();
			System.exit(1);
		}

		Socket socket = null;
		try {
			socket = new Socket(args[0], Integer.parseInt(args[1]));
		} catch (IOException ie) {
			System.out.println("cannot establish socket connection to " + args[0] + ":" + args[1] + " - " + ie);
			System.exit(2);
		}

		TestData td = new TestData("I", "GMSH0001", "0", "0001", "20020930", "09000000", "Ʈ���̵�", "�ڴ��", "123456789012",
				"����� ������!", "������", "/best/good.pdf", "�ϵ��� ��ڸ��� �˾�!");

		TestData td1 = new TestData();
		TestData td2 = new TestData();

		System.out.println("td2" + td);
		System.out.println("td2" + td1);
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		System.out.println("td2" + td2);
		System.out.println("in" + in);
		System.out.println("out:" + out);

		try {
			// first write to server socket
			td1.print();
			td1.writeDataExternal(out);
			out.flush();
			System.out.println("write to socket server ends");

			// later, read from server socket
			System.out.println("0");
			td2.readDataExternal(in);
			System.out.println("1");
			td2.print();
			System.out.println("read from socket server ends");
		} finally {
			out.close();
			in.close();
			socket.close();
		}
	}
}
