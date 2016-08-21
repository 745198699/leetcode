package string;

public class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] array1 = new int[26];
        int [] array2 = new int[26];
        for(char c1 :ransomNote.toCharArray())
        	array1[c1-'a']++;
        for(char c2:magazine.toCharArray())
        	array2[c2-'a']++;
        
        for(int i=0;i<26;i++){
        	if(array1[i]<array2[i])
        		return false;
        }
    	
    	return true;
    }

	public static void main(String[] args) {

	}

}
