package backtrace;

import java.util.*;

public class asd {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        int[] pre=new int[m+1];
        List<PII> v=new ArrayList<>();
        v.add(new PII(Integer.MIN_VALUE,Integer.MIN_VALUE));
        for(int i=1;i<=m;i++){
            int first=scanner.nextInt();
            int second=scanner.nextInt();
            v.add(new PII(first,second));
        }
        Collections.sort(v,Comparator.comparingInt(o->o.first));
        for(int i=1;i<=m;i++){
            pre[i]+=pre[i-1]+v.get(i).second-v.get(i).first;
        }
        int ans=0;
        for(int i=1;i<=m;i++){
            int fi=v.get(i).first;
            int se=v.get(i).first+k;
            int l=1,r=m;
            while (l<r){
                int mid=(l+r+1)/2;
                if(v.get(mid).first<=se){
                    l=mid;
                }else {
                    r=mid-1;
                }
            }
            int re=pre[l-1]-pre[i-1];
            re+=Math.min(v.get(l).second,se)-v.get(l).first;
            ans=Math.max(ans,re);
        }
        System.out.println(ans);
    }


}

class  PII{
    int first;
    int second;
    PII(int first,int second){
        this.first=first;
        this.second=second;
    }
}
