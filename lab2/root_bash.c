/*
  Program taken from http://koltsoff.com/pub/getroot/
  All credits goes to Aleksandr Koltsoff (czr@iki.fi)
  Comments have been striped from original source
*/

#include <unistd.h>	/* setuid, .. */
#include <sys/types.h>	/* setuid, .. */
#include <grp.h>	/* setgroups */
#include <stdio.h>	/* perror */

int main (int argc, char** argv) {

  gid_t newGrp = 0;

  if (setuid(0) != 0) {
    perror("Setuid failed, no suid-bit set?");
    return 1;
  }
  setgid(0);
  seteuid(0);
  setegid(0);

  setgroups(1, &newGrp);

  execvp("/bin/bash", argv);

  return 0;
}
