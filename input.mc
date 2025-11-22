int fac(int i) {
    if (x <= 1)
        return 1;

    return fac(i-1) * i;
}

void main() {
    x = 3;
    fac(x);
    while(x < 10){
        ++x;
    }
    return x;
}

int alpha(int a, int b, int c){
    {
        a = 1 + 2 + 3;
        y = 2 + 3 + 4;
        z = a + y + z;
    }
    if (z <= 1){
        return 1;
    } else{
        return 1 + z;
    }
}