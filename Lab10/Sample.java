import java.util.*;

class MyException extends Exception
{
    MyException(final String s)
    {
        super(s);
    }
}


class MyImplementation
{
 
     public boolean isOperator(final char c)
    {
        if(c=='+'||c=='-'||c=='/'||c=='*'||c=='^')
            return true;
        else
            return false;
    }
    public int performOperation(final Stack<Integer> numbers, final Stack<Character> operations) 
    {
        final int a = numbers.pop();
        final int b = numbers.pop();
        final char operation = operations.pop();
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0;
    }
    static int precedence(final char c)
    {
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
	public int performExpression (final String expression) throws MyException
	{
         //Stack for Numbers
        final Stack<Integer> numbers = new Stack<>();
        //Stack for operators
        final Stack<Character> operations = new Stack<>();
        
        for(int i=0; i<expression.length();i++) 
        {
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                
                int num = 0;
                while (Character.isDigit(c)) 
                {
                    num = num*10 + (c-'0');
                    i++;
                    if(i < expression.length())
                        c = expression.charAt(i);
                    else
                        break;
                }
                i--;
              
                numbers.push(num);
            }
            else if(c=='(')
            {
                
                operations.push(c);
            }
            
            else if(c==')') 
            {
                while(operations.peek()!='(')
                {
                    final int output = performOperation(numbers, operations);
                    //push it back to stack
                    numbers.push(output);
                }
                operations.pop();
            }
            // current character is operator
            else if(isOperator(c))
            {

                while(!operations.isEmpty() && precedence(c)<=precedence(operations.peek())){
                    final int output = performOperation(numbers, operations);
                    //push it back to stack
                    numbers.push(output);
                }
                //now push the current operator to stack
                operations.push(c);
            }
            else
            {
                throw new MyException("Invalid Arithmatic Expression");
            }
        }
        //If here means entire expression has been processed,
        //Perform the remaining operations in stack to the numbers stack

        while(!operations.isEmpty()){
            final int output = performOperation(numbers, operations);
            //push it back to stack
            numbers.push(output);
        }
        return numbers.pop();
	}
    
    public int CountTheLetters(String str) throws MyException 
    {
        int count=0;
        str = str.toLowerCase();
        final char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) 
        {
        final char ch = charArray[i];
        if (!(ch >= 'a' && ch <= 'z')) 
        {
            throw new MyException("Non English Character Occured");
        }
        else
        {
            count++;
        }
        }
        return count;
   }
}
class Sample
{
    
     public static void main(final String args[])
     { 
         int num =0;
         final Scanner in = new Scanner(System.in);
         System.out.println("Enter the String ");
         final String str = in.nextLine();
         final MyImplementation obj = new MyImplementation();
         try
         {
             num = obj.CountTheLetters(str);
             System.out.println("Total letters are :- " +num);
         }
         catch(final Exception e)
		{
			System.out.print("Exception : ");
			System.out.println(e.getMessage());
		}
         
	System.out.println("Enter an arithmetic Expression: ");
		final String exp = in.nextLine();
		try
        {
			final double ans = obj.performExpression(exp);
			System.out.println("Arithmatic Evaluation is "+ans);
		}
		catch(final Exception ex)
        {
			System.out.println("Exception Occured!!");
			System.out.println(ex.getMessage());
		}
         
    
}
}