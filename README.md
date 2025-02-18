#   On the construction of the square roots of natural numbers




## Introduction

This repository contains a *Java* program that explores a rational sequence designed to approximate square roots of positive integers.

The idea originated from a *topology of metric space* course, where I was challenged to find a rational sequence that converges to the square root of two. Later, inspired by Euler’s method for approximating square roots, I derived a general expression for computing square roots using a sequence.

To verify its accuracy and convergence properties, I implemented this Java program to generate and analyze the sequence for different values. Since manual calculations quickly became impractical (e.g., for *n=5*, the sequence produces extremely large values), this program automates the process and provides insights into its behavior.

A more detailed theoretical discussion, including proofs and derivations, is available in a separate LaTeX-written article in another repository which is for now still private for some reasons.



##	About this program :

In this repository, I'm just going to cover the algorithm part of the main idea. 

####	About the class _*Fraction*_: 
Indeed, as we are using *Java* while dealing with *rational numbers*, I prefered to implement my owned version of what we define by rational number in programming : _*fractions*_.

So this program provides an object called _**Fraction**_ which represents fraction in mathematical world.

So by doing :
```java
	Fraction one_half = new Fraction(1,2)
```
It will be similar on doing :


$$
x=\frac{1}{2}
$$



The program provides some default fraction such as `Fraction.ZERO`and `Fraction.ONE`which are the zero fraction and the one fraction.

In mathematical world, the `Fraction.ZERO` is just :


$$
Let\,\,q\in\mathbb{N}^{*},\quad 0 = \frac{0}{q} = \frac{0}{1}
$$


And the `Fraction.ONE`is just :


$$
Let\,\,p\in\mathbb{N}^{*}, \quad 1 = \frac{p}{p} = \frac{1}{1}
$$


The fraction `Fraction` acts exactly as a mathematical fraction does. So, all operation provided by the *filed* :


$$
(\mathbb{Q}, +, \,\cdot\,)
$$


is available.



##	About the [*SquareRoots*](src/main/java/dev/razafindratelo/sequences/SquareRoot.java) :

`SquareRoot`implements an interface called `Sequence`. This is the program where This repository focuses in.

According to its implementation, we can find the expression of the sequence in the [SquareRoots](src/main/java/dev/razafindratelo/sequences/SquareRoot.java)`.sq_n` method.

The mathematical expression of this sequence is :

<p align="center">
	$$
		\text{let } m\in\mathbb{N}^{*} \text{ and } c^{2}\in\mathbb{N}^{*} \text{ be the mininum perfect square root greater or equal than }m. \\[8mm]
		\text{Let $(a_n)_{n\in\mathbb{N}^{*}}$ be a sequence defined by the following recursion : } \qquad
		(a_n) : \quad
		\begin{cases}
		a_1 = \frac{2c}{c^{2}-m}	\\	\\
		a_2 = \frac{4c\left(c^{2} + m\right)}{\left(c^{2}-m\right)^{2}}	\\	\\
		a_{n+2} = 2a_{n+1}\cdot\left(\frac{a_{n+1}^{2}}{2a_{n}^{2}} - 1\right)
		\end{cases}
	$$
</p>



Then the final sequence that gives us the square root of *m* is the following :


$$
\therefore \quad \sqrt{m} = c-\lim_{n \longrightarrow +\infty} \sum_{k = 1}^{n}{\frac{1}{a_k}} = c-\sum_{n = 1}^{\infty}{\frac{1}{a_n}} = \lim_{n \longrightarrow +\infty} x_n \\
\qquad \qquad Where \quad (x_n) \quad is \ defined \ by \ : \quad
x_n = c - \sum_{k = 1}^{n}{\frac{1}{a_k}}
$$



> Author: Abegà Razafindratelo
