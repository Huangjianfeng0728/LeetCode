package binary;
public class SVNRepo {
    public static boolean isBadVersion(int k);
}
public class FirstBadVersion {
    public int findFirstBadVersion(int n) {
        if (n<=0){
            throw new IllegalArgumentException("n should be a position number");
        }
        int s=1;
        int e=n;
        while(s+1<e){
            int mid=s+(e-s)/2;
            if (!SVNRepo.isBadVersion(mid)){
                s=mid;
            }else{
                e=mid;
            }
        }
        if (SVNRepo.isBadVersion(e)){
            return e;
        }
        return -1;
    }
}
