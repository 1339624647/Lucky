import java.util.Scanner;

public class Lucky1 {
	static int key = -1;// 用户输入的选项
	static int num = 0, sum;// 表示用户在系统中的编号
	static int[] cardNum = new int[10];// 会员卡号
	static String[] userName = new String[10];// 用户名
	static String[] passWord = new String[10];// 密码

	public static void main(String[] args) {
		while (true) {
			key = showMenu();// 调用showMenu获得用户输入
			switch (key) {
			case 1:
				zMenu();// 选1调用注册方法
				xMenu();// 询问是否继续
				break;
			case 2:
				dMenu();// 选2调用登录方法
				xMenu();// 询问是否继续
				break;
			case 3:
				cMenu();// 选3调用抽奖方法
				xMenu();// 询问是否继续
				break;

			default:
				System.out.println("输入错误，系统退出");
				break;
			}
		}
	}

	public static void xMenu() {// 该方法询问是否继续
		System.out.println("继续吗？y/n");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		if (choice.equals("y")) {// 输入“y”继续
		} else {// 输入“n”退出系统
			System.out.println("系统退出，谢谢使用！");
		}
	}

	public static int showMenu() {// 欢迎界面
		Scanner input = new Scanner(System.in);
		System.out.println("*****欢迎进入奖客富翁系统！*****\r\n1.注册\r\n2.登陆\r\n3.抽奖");
		System.out.println("*******************************");
		System.out.println("请选择菜单：");
		int key = input.nextInt();
		return key;
	}

	public static void zMenu() {// 定义注册方法
		Scanner input = new Scanner(System.in);
		System.out.println("奖客富翁系统>注册");
		System.out.println("请填写个人注册信息：");
		System.out.println("用户名：");
		userName[num] = input.next();// 用数组存储用户信息
		for (int i = 0; i < num; i++) {
			while(userName[num].equals(userName[i])){
				System.out.println("该用户名已被用，请重新输入：");
				userName[num] = input.next();
			}
		}
		System.out.println("密码：");
		passWord[num] = input.next();
		cardNum[num] = (int) (Math.random() * 10 + 1);// 随机生成会员卡号
		for (int i = 0; i < num; i++) {
			while (cardNum[num] == cardNum[i]) {
				cardNum[num] = (int) (Math.random() * 10 + 1);
			}
		}

		System.out.println(
				"注册成功！请记好您的会员卡号\r\n用户名：" + userName[num] + "\r\n密码：" + passWord[num] + "\r\n会员卡号：" + cardNum[num]);
		num++;// 注册成功后编号加1，等待下一个注册用户
	}

	public static void dMenu() {// 定义登录方法
		Scanner input = new Scanner(System.in);
		sum = -1;
		System.out.println("奖客富翁系统>登陆");
		System.out.println("请输入用户名：");
		String iuserName = input.next();
		for (int i = 0; i < userName.length; i++) {
			if (iuserName.equals(userName[i])) {
				sum = i;// 循环比较输入的用户名和系统中的用户，匹配成功则调用编号
				for (i = 1; i <= 3; i++) {// 控制密码输入次数
					System.out.println("请输入密码:");
					String userPass = input.next();
					if (userPass.equals(passWord[sum])) {// 判断密码是否正确
						System.out.println("欢迎您：" + userName[sum]);
						return;
					} else {
						System.out.println("密码错误。您还有" + (3 - i) + "次机会");
					}
					if (i > 3) {
						System.out.println("密码错误次数过多，系统退出");
					}
				}
			} else if (i >= userName.length - 1) {
				System.out.println("新用户请先注册");
			}
		}
	}

	public static void cMenu() {// 定义抽奖方法
		Scanner input = new Scanner(System.in);
		System.out.println("奖客富翁系统>抽奖");
		System.out.println("您的卡号：" + cardNum[sum]);
		int[] luckyNum = new int[5];
		System.out.println("幸运随机数为：");
		for (int i = 0; i < luckyNum.length; i++) { // 为了使抽到的5个随机数不是重复的特意使用循环判断
			luckyNum[i] = (int) ((int) 10 * Math.random());// 如果之前的随机数与现在的冲突则重新选择当前随机数
			for (int j = 0; j < i; j++) {
				if (luckyNum[j] == luckyNum[i]){
					luckyNum[i] = (int) ((int) 10 * Math.random());
					j=-1;
					}
			}
			System.out.print(luckyNum[i] + "  "); // 输出所有的幸运随机数
		}

		for (int k = 0; k < luckyNum.length; k++) { // 循环对比随机数如果有相等的则告知中奖
			if (cardNum[sum] == luckyNum[k]) {
				System.out.println("恭喜你，中奖了！");
			}
			else if (k == luckyNum.length - 1) {
				System.out.println("很遗憾，您不是本日的幸运会员");
			}

		}
	}
}
