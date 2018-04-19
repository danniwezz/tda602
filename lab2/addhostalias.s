	.file	"addhostalias.c"
	.version	"01.01"
gcc2_compiled.:
.section	.rodata
.LC0:
	.string	"%s\t%s\t%s\n"
.LC1:
	.string	"a"
.LC2:
	.string	"/etc/hosts"
.LC3:
	.string	"fopen"
.LC4:
	.string	"close"
.text
	.align 4
.globl add_alias
	.type	 add_alias,@function
add_alias:
	pushl %ebp
	movl %esp,%ebp
	subl $280,%esp
	addl $-12,%esp
	movl 16(%ebp),%eax
	pushl %eax
	movl 12(%ebp),%eax
	pushl %eax
	movl 8(%ebp),%eax
	pushl %eax
	pushl $.LC0
	leal -256(%ebp),%eax
	pushl %eax
	call sprintf
	addl $32,%esp
	addl $-8,%esp
	pushl $.LC1
	pushl $.LC2
	call fopen
	addl $16,%esp
	movl %eax,%eax
	movl %eax,-260(%ebp)
	cmpl $0,-260(%ebp)
	jne .L3
	addl $-12,%esp
	pushl $.LC3
	call perror
	addl $16,%esp
	addl $-12,%esp
	pushl $1
	call exit
	addl $16,%esp
	.p2align 4,,7
.L3:
	addl $-8,%esp
	leal -256(%ebp),%eax
	pushl %eax
	movl -260(%ebp),%eax
	pushl %eax
	call fprintf
	addl $16,%esp
	addl $-12,%esp
	movl -260(%ebp),%eax
	pushl %eax
	call fclose
	addl $16,%esp
	movl %eax,%eax
	testl %eax,%eax
	je .L4
	addl $-12,%esp
	pushl $.LC4
	call perror
	addl $16,%esp
	addl $-12,%esp
	pushl $1
	call exit
	addl $16,%esp
	.p2align 4,,7
.L4:
.L2:
	leave
	ret
.Lfe1:
	.size	 add_alias,.Lfe1-add_alias
.section	.rodata
	.align 32
.LC5:
	.string	"Usage: %s ipaddress hostname alias \n"
.text
	.align 4
.globl main
	.type	 main,@function
main:
	pushl %ebp
	movl %esp,%ebp
	subl $8,%esp
	cmpl $4,8(%ebp)
	je .L6
	addl $-8,%esp
	movl 12(%ebp),%eax
	movl (%eax),%edx
	pushl %edx
	pushl $.LC5
	call printf
	addl $16,%esp
	addl $-12,%esp
	pushl $1
	call exit
	addl $16,%esp
	.p2align 4,,7
.L6:
	addl $-4,%esp
	movl 12(%ebp),%eax
	addl $12,%eax
	movl (%eax),%edx
	pushl %edx
	movl 12(%ebp),%eax
	addl $8,%eax
	movl (%eax),%edx
	pushl %edx
	movl 12(%ebp),%eax
	addl $4,%eax
	movl (%eax),%edx
	pushl %edx
	call add_alias
	addl $16,%esp
	xorl %eax,%eax
	jmp .L5
	.p2align 4,,7
.L5:
	leave
	ret
.Lfe2:
	.size	 main,.Lfe2-main
	.ident	"GCC: (GNU) 2.95.3 20010315 (release)"
