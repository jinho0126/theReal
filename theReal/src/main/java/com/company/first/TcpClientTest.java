package com.company.first;
//TcpClientTest.java

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpClientTest {
	public static void main(String[] args) {
		try {
			String serverIP = "127.0.0.1"; // 127.0.0.1 & localhost ����
			System.out.println("������ �������Դϴ�. ���� IP : " + serverIP);
			System.out.println("Total Memory : " + Runtime.getRuntime().totalMemory());
			System.out.println("Free Memory : " + Runtime.getRuntime().freeMemory());
			System.out.println(
					"Used Memory : " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

			// ������ �����Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIP, 5010);

			/*
			 * 
			 * Packet packet = new Packet(); Item item1 = Item.create("�̸�", 10,
			 * "������"); Item item2 = Item.create("��ȭ��ȣ", 11, "01071064573"); Item
			 * item3 = Item.create("�̸���", 20, "god870225@naver.com"); Item item4
			 * = Item.create("�׽�Ʈ", 10, "1234567"); Item item5 =
			 * Item.create("�ٹٲ�", 1, "\r"); Item item6 = Item.create("�̸�1", 10,
			 * "������1"); Item item7 = Item.create("��ȭ��ȣ2", 11, "01071064573");
			 * Item item8 = Item.create("�̸���3", 20, "god870225@naver.com"); Item
			 * item9 = Item.create("�׽�Ʈ4", 10, "1234567"); Item item10 =
			 * Item.create("�ٹٲ�5", 4, "\r"); packet.addItem(item1);
			 * packet.addItem(item2); packet.addItem(item3);
			 * packet.addItem(item4); packet.addItem(item5);
			 * packet.addItem(item6); packet.addItem(item7);
			 * packet.addItem(item8); packet.addItem(item9);
			 * packet.addItem(item10); System.out.println(packet.raw());
			 * 
			 */

			// ������ �Է½�Ʈ���� ��´�.

			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in); // �⺻�� ������ ó���ϴ� ������Ʈ��

			// �������� ���� ���� �����͸� ����Ѵ�.
			System.out.println("�����κ��� ���� �޼��� : " + dis.readUTF());
			System.out.println("������ �����մϴ�.");

			// ��Ʈ���� ������ �ݴ´�.
			dis.close();
			socket.close();

		} catch (ConnectException ce) {

			ce.printStackTrace();

		} catch (IOException ie) {

			ie.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} // try - catch
	} // main
} // TcpClientTest

/*
 *
 * ���
 * 
 * ������ �������Դϴ�. ���� IP : 127.0.0.1 �����κ��� ���� �޼��� : �����κ����� �޼����Դϴ�. ������ �����մϴ�.
 * 
 */