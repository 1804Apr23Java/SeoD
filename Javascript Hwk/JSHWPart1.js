
var homework = {};

homework.fibonacci = function(n){
var a = 0;
var b = 1;
var c;
var i;
  for (i = 0; i < n - 1; i++)
    {
      c = a + b;
      a = b;
      b = c;
    //console.log(b);
      
    }
    return b;
};

//homework.fibonacci(10);

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/

//var x = [2,4,5,1,3,1];

homework.sort = function(array) {
var i, j, k, l;


for (i = 0; i < array.length; i++)
            {
                for (j = i+1; j < array.length; j++)
                {
                    if (array[i] > array[j])
                    {
                      k = array[i];
                      l = array[j];
                      array[i] = l;
                      array[j] = k;
                    }
                }
            }
return x;
};

//console.log(homework.sort(x));

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    if (n == 1)
      {
        return 1;
      }
    else
      {
    return (n * homework.factorial(n-1));
      }
};

//console.log(homework.factorial(4));

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
var i, j;
var y = [];
  for (i = 0; i < n; i++)
    {
      //console.log(array[0]);
    for (j = 1; j < array.length; j++)
      {
      y[j - 1] = array[j];
      }
      //console.log(array[0]);
      y[array.length - 1] = array[0];
      //console.log(array[0]);
      array = y;
      y = [];
      //console.log(array);
      //console.log(array);
    }

  return array
};

//console.log(homework.rotateLeft([1,2,3,4,5], 6));

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
var i;
var left = 0;
var right = 0;

      for (i = 0; i < bracketsString.length; i++)
        {
          switch(bracketsString.charAt(i))
          {
            case "(":
              if (bracketsString.charAt(bracketsString.length - (i + 1)) === ")")
                {break;}
              else
                {return false;}
            case "[":
              if (bracketsString.charAt(bracketsString.length - (i + 1)) === "]")
                {break;}
              else
                {return false;}
            case "{":
              if (bracketsString.charAt(bracketsString.length - (i + 1)) === "}")
                {break;}
              else
                {return false;}
            case ")":
              if (bracketsString.charAt(bracketsString.length - (i + 1)) === "(")
                {break;}
              else
                {return false;}
            case "]":
              if (bracketsString.charAt(bracketsString.length - (i + 1)) === "[")
                {break;}
              else
                {return false;}
            case "}":
              if (bracketsString.charAt(bracketsString.length - (i + 1)) === "{")
                {break;}
              else
                {return false;}

          }
        }
      return true;
    


};

console.log(homework.balancedBrackets("([)]"));