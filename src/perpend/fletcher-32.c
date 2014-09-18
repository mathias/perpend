#include <stdio.h>
#include <string.h>
#include <stdlib.h>


uint32_t fletcher32( uint16_t const *data, size_t len )
{
        uint32_t sum1 = 0xffff, sum2 = 0xffff;

        while (len) {
                unsigned tlen = len > 359 ? 359 : len;

                len -= tlen;

                do {
                  sum1 += *data++;
                  sum2 += sum1;
                } while (--tlen);

                sum1 = (sum1 & 0xffff) + (sum1 >> 16);
                sum2 = (sum2 & 0xffff) + (sum2 >> 16);

                printf("sum1: %i\n", sum1);
                printf("sum2: %i\n", sum2);
        }
        /* Second reduction step to reduce sums to 16 bits */
        sum1 = (sum1 & 0xffff) + (sum1 >> 16);
        sum2 = (sum2 & 0xffff) + (sum2 >> 16);
        return sum2 << 16 | sum1;
}

int main() {
  char str[] = "abcde";
  size_t len = strlen(str);

  uint16_t as_ints[len];

  for(int i=0; i <= len; i++) {
    as_ints[i] = str[i];
  };

  printf("Checksum: %i", fletcher32(as_ints, len));
  printf("\n\n");
  return 0;
}
