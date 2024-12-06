class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        // cin.tie(null);

        map<int,int> mpps;
        for(auto i:banned){
            mpps[i]++;
        }
        int sum=0;
        int count=0;
        for(int i=1;i<=n;i++){
            if(mpps.find(i)==mpps.end()  && sum+i <=maxSum){
                sum+=i;
                count++;
            }

            if(sum>maxSum){
                return count;
            }
        }
        return count;
    }
};