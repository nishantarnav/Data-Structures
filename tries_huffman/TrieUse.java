package tries_huffman;

public class TrieUse {

	public static void main(String[] args) {
		Trie t= new Trie();
		t.add("this");
		t.add("news");
		System.out.println(t.search("news"));
		System.out.println(t.search("bat"));
		t.remove("news");
		System.out.println(t.search("news"));
	}

}
