class Solution {
    public int nextGreaterElement(int n) 
    {
        long m = n;
        
        int count[] = new int[10];
        
        int cur = -1;
        int prev = -1;
        
        while(m>0)
        {
            cur = (int)m%10;
            m = m/10;
            count[cur]++;
            
            if(prev>cur)
            {
                int num = cur+1;
                
                while(count[num]==0)    num++;
                
                count[num]--;
                
                m = m*10 + num;
                
                for(int i=0;i<=9;i++)
                {
                    while(count[i]>0)
                    {
                        m = m*10+i;
                        count[i]--;
                    }
                }
                
                return m>Integer.MAX_VALUE?-1:(int)m;
            }
            
            prev = cur;
        }
        
        return -1;
    }
}
