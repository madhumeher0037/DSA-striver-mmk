//         Here the problem is comparing the two strings that contains the same letters.
//         we are using simple but powerfull approach,where we set bits to integer for each character.This integer is called mask.
//         For every character of string,we set the bit to 1 at pos where it belongs to 26 aplhabets.
//         ex:'cdea' we set the bits at 00000000000000000000011101
//         To set the bit 1 at specific pos we use left shift operator << and we perform the or operation with 1.
//         ex: mask|=1<<2 => 00000000000000000000000100
//         When we perform the 'AND' operation on mask values of two string,if we get other than '0' then the two string contains the same letters.
//         leetcode 318
class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] mask = new int[words.length];
        for(int i=0;i<words.length;i++) mask[i]=getMask(words[i]);
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i]&mask[j])==0) max = Math.max(max,(words[i].length()*words[j].length()));
                // else System.out.println((mask[i]&mask[j]));
            }
        }
        return max;
    }
    public static int getMask(String s){
        int mask = 0;
        for(int i=0;i<s.length();i++){
            mask|=1<<(s.charAt(i)-'a');
        }
        return mask;
    }
}