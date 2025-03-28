# On the construction of the square roots of natural numbers

## Introduction

This repository contains a _Java_ program that explores a rational sequence
designed to approximate square roots of positive integers.

The idea originated from a _topology of metric space_ course, where I was
challenged to find a rational sequence that converges to the square root of two.
Later, inspired by Euler’s method for approximating square roots, I derived a
general expression for computing square roots using a sequence.

To verify its accuracy and convergence properties, I implemented this Java
program to generate and analyze the sequence for different values. Since manual
calculations quickly became impractical (e.g., for _n=5_, the sequence produces
extremely large values), this program automates the process and provides
insights into its behavior.

A more detailed theoretical discussion, including mathematical proofs, is
available in a separate LaTeX-written article in another repository which is for
now still private for some reasons.

## About this program :

In this repository, I'm just going to cover the algorithm part of the main idea.

#### Java Version and dependencies

This program is written in **Java 22** and use **Maven** as dependency manager.
Make sure you have JDK 22 installed before running it.

#### About the class **Fraction**:

Indeed, as we are using _Java_ while dealing with _rational numbers_, I prefered
to implement my owned version of what we define by rational number in
programming : **fractions**.

The program provides an object called _**Fraction**_ which represents fraction
in mathematical world.

So by doing :

```java
Fraction oneHalf = new Fraction(1,2);
```

It will be similar on doing :

$$
x=\frac{1}{2}
$$

The program provides some default fraction such as `Fraction.ZERO`and
`Fraction.ONE`which are the zero fraction and the one fraction.

In mathematical world, the `Fraction.ZERO` is just :

<p>
$$
 q\in\mathbb{N}^{*},\quad 0 = \frac{0}{q} = \frac{0}{1}
$$
</p>

And the `Fraction.ONE`is just :

<p>
$$
 p\in\mathbb{N}^{*}, \quad 1 = \frac{p}{p} = \frac{1}{1}
$$
</p>

The fraction `Fraction` acts exactly as a mathematical fraction does. So, all
operation provided by the _filed_ :

<p>
$$
 (\mathbb{Q}, +, \ \cdot \ )
$$
</p>

is available.

## About the Test Data

To verify the accuracy of the sequence, we compare our results with
high-precision values from reliable external sources.

All test data used in this repository come from trusted mathematical sources,
including:

- NASA's _Astronomy Picture of the Day_ (APOD) numerical data repository
- The University of Arizona’s _Mathematical Constants_ database

Here are the data files and their sources:

| File Name          | Source                                                                           |
| ------------------ | -------------------------------------------------------------------------------- |
| `sqrt_2.txt`       | [NASA - sqrt2.1mil](https://apod.nasa.gov/htmltest/gifcity/sqrt2.1mil)           |
| `sqrt_3.txt`       | [NASA - sqrt3.1mil](https://apod.nasa.gov/htmltest/gifcity/sqrt3.1mil)           |
| `sqrt_5.txt`       | [NASA - sqrt5.1mil](https://apod.nasa.gov/htmltest/gifcity/sqrt5.1mil)           |
| `sqrt_6.txt`       | [NASA - sqrt6.1mil](https://apod.nasa.gov/htmltest/gifcity/sqrt6.1mil)           |
| `sqrt_7.txt`       | [NASA - sqrt7.1mil](https://apod.nasa.gov/htmltest/gifcity/sqrt7.1mil)           |

These sources provide extremely precise approximations of well-known
mathematical constants. Since NASA rely on
precise calculations for research and space exploration, their datasets are
considered highly accurate.

By using these sources, we ensure that the program's results are tested against
verified, high-precision values, reinforcing the reliability of the algorithm.


### About tests precision :

All of the tests found in the [test](src/test/java/dev/razafindratelo/sequences/) package have exactly `ONE MILLION` (`1 000 000`) decimal places.

### Mathematical remarks about the [tests](src/test/java/dev/razafindratelo/sequences/):

As we can notice in tests done in the [test](src/test/java/dev/razafindratelo/sequences/) package, we can see that :

<div>
	<p>
	$$
	\vert \sqrt{2} - x_{21} \vert < 10^{-10^{9}}
	$$
	</p>
	<p>
	$$
	\vert \sqrt{3} - x_{20} \vert < 10^{-10^{9}}
	$$
	</p>
	<p>
	$$
	\vert \sqrt{5} - x_{21} \vert < 10^{-10^{9}}
	$$
	</p>
	<p>
	$$
	\vert \sqrt{6} - x_{20} \vert < 10^{-10^{9}}
	$$
	</p>
	<p>
	$$
	\vert \sqrt{7} - x_{20} \vert < 10^{-10^{9}}
	$$
	</p>
</div>

## About the [_SquareRoots_](src/main/java/dev/razafindratelo/sequences)

`SquareRoot` and `SquareRootSub` implement an abstract class called `Sequence`,
which is the super class of all sequences that are going to be used in this
program. That `SquareRoot` class is where This repository focuses in.

According to its implementation, we can find the expression of the sequence in
the [SquareRoots](src/main/java/dev/razafindratelo/sequences/SquareRoot.java)
`kThValue` method which gives us the k-th value of the square root sequence. The
natural mathematical notation will be <p>$$ x_k $$

</p>

The mathematical expression of this sequence is the following :

<p align="center">
$$
    \text{Let } m\in\mathbb{N}^{*}. \\
$$
<p>
	$$
		\text{Let } P \text{ be the set of all perfect square. }. \\
	$$
</p>
<p>
	$$
	\text{Now, let } c \text{ be the smallest perfect square greater or equal to } m
    	\Longleftrightarrow  \ c^{2} = \min_{s\in P, s \geq m} \lbrace s - m \rbrace
	$$

</p>

<p align="center">
	$$
		\text{Let $(a_n)_{n\in\mathbb{N}^{*}}$ be a sequence defined by the following recursion : } \qquad
	$$
</p>
<p>
	$$
	(a_n) \ : \quad
		\begin{cases}
		a_1 = \frac{2c}{c^{2}-m}	\\
		a_2 = \frac{4c\left(c^{2} + m\right)}{\left(c^{2}-m\right)^{2}}	\\
		a_{n+2} = a_{n+1}\cdot\left(\frac{a_{n+1}^{2}}{a_{n}^{2}} - 2\right)
		\end{cases}
	$$
</p>

Then the final sequence that gives us the square root of _m_ is the following :

<p>
$$
\therefore \quad \sqrt{m} = c-\lim_{n \longrightarrow +\infty} \sum_{k = 1}^{n}{\frac{1}{a_k}} 
$$
</p>

<p>
$$
= c-\sum_{n = 1}^{\infty}{\frac{1}{a_n}} = \lim_{n \longrightarrow +\infty} x_n \\
$$
</p>

<p>
$$
\text{Where } (x_n) \text{ is defined by : } \\
x_n = c - \sum_{k = 1}^{n}{\frac{1}{a_k}}
$$
</p>

Where the `SquareRootSub` class represents the sequence <p>
$$ (a_{n})_{\mathbb{N^{*}}} $$

</p>

and the `SquareRoot` class represents the sequence

<p>$$ (x_{n})_{\mathbb{N^{*}}} $$

</p>

> Author: Abegà Razafindratelo
