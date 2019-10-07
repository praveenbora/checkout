# Shopping Cart Programming Exercise

## Step 1: Shopping cart
1. You are building a checkout system for a shop which only sells apples and
oranges.

2. Apples cost 60p and oranges cost 25p.

3. Build a checkout system which takes a list of items scanned at the till and outputs
the total cost

4. For example: [ Apple, Apple, Orange, Apple ] => £2.05

5. Make reasonable assumptions about the inputs to your solution; for example, many
candidates take a list of strings as input


## Step 2: Simple offers
1. The shop decides to introduce two new offers
  2. buy one, get one free on Apples
  3. or the price of 2 on Oranges
4. Update your checkout functions accordingly


## To run the application:

```
sbt clean run
```


### To cleanup and remove the target directory

```
sbt clean 
```
or
```
find . -name target -type d -exec rm -rf {} \;
```

## Running Test
```
sbt clean test
```