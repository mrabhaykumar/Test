
class node {
	int data;
	node  next = null;
	node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class linklist {

	/**
	 * @param args
	 */
	static node curr = null;
	public static node reverseLinkList (node head, node prev) {
		if (head.next == null) {
			curr = head;
	     	curr.next = prev;
			return null;
		}
		node next = head.next;
		head.next = prev;
		reverseLinkList(next,head);
		return curr;
		
		
	}
	public static node reverseln(node head) {
		node next = null;
		node prev = null;
		node current = head;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	public static node reverseAlternate(node head) {
		node newhead = null;
		node next = null;
		while(head!=null && head.next!=null) {
			if(next!=null) {
				next.next.next = head.next;
			}
			next = head.next;
			head.next = head.next.next;
			next.next = head;
			if(newhead ==null)
				newhead = next;
			head = head.next;
		}
		return newhead;
	}
	public static void main(String[] args) {
		node head= new node(10);
		head.next = new node(20);
		head.next.next = new node(30);
		head.next.next.next = new node(40);
		head = reverseAlternate(head);
//		while(head!=null) {
//			System.out.println(head.data);
//			head = head.next;
//		}
		int[] arr = {3,4,63,346,3463,2,63,10,4,14};
		insertionsort(arr);
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
	public static void selectionsort(int [] arr) {
		for(int i = 0;i<arr.length;i++) {
			
			int pos = i;
			for (int j = i+1;j<arr.length;j++) {
				if(arr[j]<=arr[pos]) {
					pos = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
		}
	}
	public static void insertionsort(int [] arr) {
		for(int j =1;j<arr.length;j++) {
			int i = j-1;
			int key = arr[j];
			while(i>=0&& arr[i]>key) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}
	}
	
	public static void quicksort(int[] arr) {
		
	}
	public static void mergesort(int[] arr) {
		
	}
}
