import java.util.ArrayList;

class MySet {
	ArrayList<Integer> list;

	// 생성자1
	public MySet() {
		list = new ArrayList<>();
	}

	// 생성자2
	public MySet(int[] arr) {
		list = new ArrayList<>();

		for (int item : arr) {
			list.add(item);
		}
	}

	// 원소 추가 (중복 제거)
	public void add(int x) {
		for (int item : list) {
			if (item == x) {
				return;
			}
		}
		list.add(x);
	}

	// 교집합
	public MySet retainAll(MySet b) {
		MySet result = new MySet();
		for (int itemA : list) {
			for (int itemB : b.list) {
				if (itemA == itemB) {
					result.add(itemA);
				}
			}
		}
		return result;
	}

	// 합집합
	public MySet addAll(MySet b) {
		MySet result = new MySet();
		for (int itemA : list) {
			result.add(itemA);
		}
		for (int itemB : b.list) {
			result.add(itemB);
		}
		return result;
	}

	// 차집합
	public MySet removeAll(MySet b) {
		MySet result = new MySet();
		for (int itemA : list) {
			boolean containFlag = false;

			for (int itemB : b.list) {
				if (itemA == itemB) {
					containFlag = true;
					break;
				}
			}

			if (!containFlag) {
				result.add(itemA);
			}
		}
		return result;
	}
}


public class Practice {
	public static void main(String[] args) {
		// Test code
		MySet a = new MySet();
		a.add(1);
		a.add(1);
		a.add(1);
		System.out.println("a.list = " + a.list);
		a.add(2);
		a.add(3);
		System.out.println("a.list = " + a.list);

		a = new MySet(new int[]{1, 2, 3, 4, 5});
		MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
		System.out.println("a.list = " + a.list);
		System.out.println("b.list = " + b.list);

		MySet result = a.retainAll(b);
		System.out.println("교집합 = " + result.list);

		result = a.addAll(b);
		System.out.println("합집합 = " + result.list);

		result = a.removeAll(b);
		System.out.println("차집합 = " + result.list);
	}
}
