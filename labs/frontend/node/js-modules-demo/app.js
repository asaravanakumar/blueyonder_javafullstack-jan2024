// app.js

// Importing functions from math.js
// import { add, subtract } from './math.js';

// Function to add two numbers
function add(a, b) {
  return a + b;
}

// Function to subtract two numbers
function subtract(a, b) {
  return a - b;
}

// Using the imported functions
const resultAddition = add(5, 3);
const resultSubtraction = subtract(10, 7);

// Logging the results
console.log(`Addition: ${resultAddition}`);
console.log(`Subtraction: ${resultSubtraction}`);
