class Assignment2
{
  //Returns the near miss of z:
  //  The smaller value of equations z^n - (x^n + y^n) and (z+1)^n - (x^n + y^n)
  int nearMiss(int x, int y, int z, int n)
  {
    int zLo = abs(exp(z,n) - (exp(x,n) + exp(y,n)));
    int zHi = abs(exp((z+1),n) - (exp(x,n) + exp(y,n)));
    return zLo < zHi ? zLo : zHi;
  }
}