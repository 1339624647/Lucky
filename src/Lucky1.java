import java.util.Scanner;

public class Lucky1 {
	static int key = -1;// �û������ѡ��
	static int num = 0, sum;// ��ʾ�û���ϵͳ�еı��
	static int[] cardNum = new int[10];// ��Ա����
	static String[] userName = new String[10];// �û���
	static String[] passWord = new String[10];// ����

	public static void main(String[] args) {
		while (true) {
			key = showMenu();// ����showMenu����û�����
			switch (key) {
			case 1:
				zMenu();// ѡ1����ע�᷽��
				xMenu();// ѯ���Ƿ����
				break;
			case 2:
				dMenu();// ѡ2���õ�¼����
				xMenu();// ѯ���Ƿ����
				break;
			case 3:
				cMenu();// ѡ3���ó齱����
				xMenu();// ѯ���Ƿ����
				break;

			default:
				System.out.println("�������ϵͳ�˳�");
				break;
			}
		}
	}

	public static void xMenu() {// �÷���ѯ���Ƿ����
		System.out.println("������y/n");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		if (choice.equals("y")) {// ���롰y������
		} else {// ���롰n���˳�ϵͳ
			System.out.println("ϵͳ�˳���ллʹ�ã�");
		}
	}

	public static int showMenu() {// ��ӭ����
		Scanner input = new Scanner(System.in);
		System.out.println("*****��ӭ���뽱�͸���ϵͳ��*****\r\n1.ע��\r\n2.��½\r\n3.�齱");
		System.out.println("*******************************");
		System.out.println("��ѡ��˵���");
		int key = input.nextInt();
		return key;
	}

	public static void zMenu() {// ����ע�᷽��
		Scanner input = new Scanner(System.in);
		System.out.println("���͸���ϵͳ>ע��");
		System.out.println("����д����ע����Ϣ��");
		System.out.println("�û�����");
		userName[num] = input.next();// ������洢�û���Ϣ
		for (int i = 0; i < num; i++) {
			while(userName[num].equals(userName[i])){
				System.out.println("���û����ѱ��ã����������룺");
				userName[num] = input.next();
			}
		}
		System.out.println("���룺");
		passWord[num] = input.next();
		cardNum[num] = (int) (Math.random() * 10 + 1);// ������ɻ�Ա����
		for (int i = 0; i < num; i++) {
			while (cardNum[num] == cardNum[i]) {
				cardNum[num] = (int) (Math.random() * 10 + 1);
			}
		}

		System.out.println(
				"ע��ɹ�����Ǻ����Ļ�Ա����\r\n�û�����" + userName[num] + "\r\n���룺" + passWord[num] + "\r\n��Ա���ţ�" + cardNum[num]);
		num++;// ע��ɹ����ż�1���ȴ���һ��ע���û�
	}

	public static void dMenu() {// �����¼����
		Scanner input = new Scanner(System.in);
		sum = -1;
		System.out.println("���͸���ϵͳ>��½");
		System.out.println("�������û�����");
		String iuserName = input.next();
		for (int i = 0; i < userName.length; i++) {
			if (iuserName.equals(userName[i])) {
				sum = i;// ѭ���Ƚ�������û�����ϵͳ�е��û���ƥ��ɹ�����ñ��
				for (i = 1; i <= 3; i++) {// ���������������
					System.out.println("����������:");
					String userPass = input.next();
					if (userPass.equals(passWord[sum])) {// �ж������Ƿ���ȷ
						System.out.println("��ӭ����" + userName[sum]);
						return;
					} else {
						System.out.println("�������������" + (3 - i) + "�λ���");
					}
					if (i > 3) {
						System.out.println("�������������࣬ϵͳ�˳�");
					}
				}
			} else if (i >= userName.length - 1) {
				System.out.println("���û�����ע��");
			}
		}
	}

	public static void cMenu() {// ����齱����
		Scanner input = new Scanner(System.in);
		System.out.println("���͸���ϵͳ>�齱");
		System.out.println("���Ŀ��ţ�" + cardNum[sum]);
		int[] luckyNum = new int[5];
		System.out.println("���������Ϊ��");
		for (int i = 0; i < luckyNum.length; i++) { // Ϊ��ʹ�鵽��5������������ظ�������ʹ��ѭ���ж�
			luckyNum[i] = (int) ((int) 10 * Math.random());// ���֮ǰ������������ڵĳ�ͻ������ѡ��ǰ�����
			for (int j = 0; j < i; j++) {
				if (luckyNum[j] == luckyNum[i]){
					luckyNum[i] = (int) ((int) 10 * Math.random());
					j=-1;
					}
			}
			System.out.print(luckyNum[i] + "  "); // ������е����������
		}

		for (int k = 0; k < luckyNum.length; k++) { // ѭ���Ա�������������ȵ����֪�н�
			if (cardNum[sum] == luckyNum[k]) {
				System.out.println("��ϲ�㣬�н��ˣ�");
			}
			else if (k == luckyNum.length - 1) {
				System.out.println("���ź��������Ǳ��յ����˻�Ա");
			}

		}
	}
}
