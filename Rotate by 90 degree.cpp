void rotate(vector<vector<int> >& matrix)
{
     int n= matrix.size();
  
  
    for(int i=0; i<n-1; i++){
        for(int j=i+1; j<n; j++){
            swap(matrix[i][j],matrix[j][i]);
        }
    }
    
    
    for(int i=0; i<n/2; i++){
        for(int j=0; j<n;j++){
            swap(matrix[i][j], matrix[n-i-1][j]);
        }
    }
}
