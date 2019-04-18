package acm;

/**
 * @author kuangjunlin
 */
public class ComplexNumMul {
    /** a = x+yi;
     * b = m+ni;
     * a * b = x*m + x*n*i + y*m*i -y*n
     */
    public String complexNumberMultiply(String a, String b) {
        int[] aNum = getComplexNumber(a);
        int[] bNum = getComplexNumber(b);
        StringBuilder ans = new StringBuilder();
        ans.append(aNum[0] * bNum[0] - aNum[1] * bNum[1]);
        ans.append("+");
        ans.append(aNum[0] * bNum[1] + aNum[1] * bNum[0]);
        ans.append("i");
        return ans.toString();
    }

    public int[] getComplexNumber(String a){
        int[] ans = new int[2];
        int aOpIndex = a.indexOf("+");
        if(a.charAt(0) == '-'){
            ans[0] = -1*getNum(a,1,aOpIndex-1);
        } else {
            ans[0] = getNum(a,0,aOpIndex-1);
        }
        if(a.charAt(aOpIndex+1) == '-'){
            ans[1] = -1*getNum(a,aOpIndex+2,a.length()-2);
        } else {
            ans[1] = getNum(a,aOpIndex+1,a.length()-2);
        }
        return ans;
    }
    public int getNum(String str,int s,int e){
        int ans = 0;
        while(s <= e){
            ans = ans*10 + (str.charAt(s)-'0');
            s++;
        }
        return ans;
    }
}
