#include <stdio.h>
#include <dos.h>
main() {
 struct dostime_t t1, t2;
 long int i; 
 printf("** printf **\n");
 _dos_gettime(&t1);
 printf("  start --> %d %d.%d\n",t1.minute,t1.second,t1.hsecond);
 for (i=1l;i<=1000l;i++) {
  printf("A");
  printf("\n"); }
 _dos_gettime(&t2);
 printf("  end   --> %d %d.%d\n",t2.minute,t2.second,t2.hsecond);
 i = t2.minute*60*100 + t2.second * 100 + t2.hsecond - 
     t1.minute*60*100 - t1.second*100 - t1.hsecond;
 printf("  time = %ld milisecs\n",i); 
 printf("** putchar **\n");
 _dos_gettime(&t1);
 printf("  start --> %d %d.%d\n",t1.minute,t1.second,t1.hsecond);
 for (i=1l;i<=1000l;i++) {
  putchar('A');
  putchar('\n'); }
 _dos_gettime(&t2);
 printf("  end   --> %d %d.%d\n",t2.minute,t2.second,t2.hsecond);
 i = t2.minute*60*100 + t2.second * 100 + t2.hsecond - 
     t1.minute*60*100 - t1.second*100 - t1.hsecond;
 printf("  time = %ld milisecs\n",i); 
}
