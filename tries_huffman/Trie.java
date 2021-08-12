package tries_huffman;

class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	public TrieNode(char data) {
		this.data=data;
		isTerminating=false;
		children= new TrieNode[26];
		childCount=0;
	}
}
public class Trie{
	private TrieNode root;
	public Trie() {
		root=new TrieNode('\0');
	}
	public void add(TrieNode root, String word) {
		if(word.length()==0) {
			root.isTerminating=true;
			return;
		}
		int childIndex= word.charAt(0)-'a';
		TrieNode child= root.children[childIndex];
		if(child==null) {
			child= new TrieNode(word.charAt(0));
			root.children[childIndex]=child;
			root.childCount++;
		}
		add(child,word.substring(1));
	} 
	public void add(String word) {
		add(root,word);
	}
	public boolean search(String word) {
		return search(root,word);
	}
	public boolean search(TrieNode root, String word) {
		if(word.length()==0) {
			return root.isTerminating;
		}
		int childIndex= word.charAt(0)-'a';
		TrieNode child= root.children[childIndex];
		if(child==null) {
			 return false; 
		}
        return search(child,word.substring(1));
        }
	public void remove(String word) {
		remove(root,word);
	}
	public void remove (TrieNode root,String word) {
		//base case
		if(word.length()==0) {
			root.isTerminating=false;
			return ;
		}
		int childIndex = word.charAt(0)-'a';
		TrieNode child= root.children[childIndex];
		if(child==null) {
			return ;
		}
		remove(child,word.substring(1));
		
		//We can remove child node only if it is not terminating and its number of children is 0.
		if(!child.isTerminating && child.childCount==0 ) {
			 root.children[childIndex]=null; 
             child=null; //just free spaces related to child 
             root.childCount--;
		}
		//		 if(!child.isTerminating) {
//			 int numChild=0;
//			 for(int i=0;i<26;i++) {
//				 if(child.children[i] !=null) {
//					 numChild++;
//				 }
//			 }
//			 if(numChild==0) {
//				 //we can delete child
//				 ro ot.children[childIndex]=null; 
//				 child=null; //just free spaces related to child 
//			 }
//		 }
		
	}
}



// 1. add
//2. search
//3. remove