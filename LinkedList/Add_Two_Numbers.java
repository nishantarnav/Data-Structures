package LinkedList;

import java.util.Scanner;

public class Add_Two_Numbers {

	public static void main(String[] args) {
		ListNode l1 = takeInput();
		ListNode l2 = takeInput();
		ListNode ans= addTwoNumbers(l1,l2);
		print(ans);
		

	}
	private static ListNode takeInput() {
		ListNode head = null, tail = null;
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
				
		while(data != -1){
			ListNode  newNode = new ListNode (data);
			if(head == null){
				head = newNode;
				tail = newNode;
			}else{

				tail.next = newNode;
				tail = newNode; 
			}
			data = sc.nextInt();
		}
		sc.close();
		return head;
		
	}
public static void print(ListNode head){
		
		while(head != null){
			System.out.print(head.val +" ");
			head = head.next;
		}
		System.out.println();

	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l11= reverseLL(l1);
        ListNode l22= reverseLL(l2);
       int  len=Math.min(length(l11),length(l22));
        ListNode dummy =new  ListNode(-1);
        ListNode temp=dummy;
        int left=0;
        for(int i=0;i<len;i++){
            int sum=l1.val+l2.val+left;
            left=sum/10;
            ListNode next= new ListNode(sum);
            temp.next=next;
        }
        if(l1==null){
           int  sum=l2.val+left;
            left=sum/10;
            ListNode next= new ListNode(sum);
            temp.next=next;   
        }
        if(l2!=null){
           int  sum=l1.val+left;
            left=sum/10;
            ListNode next= new ListNode(sum);
            temp.next=next;   
        }
        return dummy.next;
        
        
        
    }
    public static ListNode reverseLL(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode tail= head.next;
        ListNode smallAns= reverseLL(head.next);
        tail.next=head;
        return smallAns;
    }
    public static int length(ListNode head){
       if(head==null){
           return 0;
       }
        if(head.next==null){
            return 1;
        }
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
	

}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
