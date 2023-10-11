import string

def roman_to_integer(roman_numeral):
    roman_to_int = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    result = 0

    # Iterate through the input Roman numeral
    for i in range(len(roman_numeral)):
        # If the current Roman character represents a smaller number
        if i > 0 and roman_to_int[roman_numeral[i]] > roman_to_int[roman_numeral[i - 1]]:
            result += roman_to_int[roman_numeral[i]] - 2 * roman_to_int[roman_numeral[i - 1]]
        else:
            result += roman_to_int[roman_numeral[i]]

    return result

def is_pangram(sentence):
    # Convert the sentence to lowercase and remove spaces/punctuation
    sentence = sentence.lower()
    sentence = ''.join(char for char in sentence if char.isalpha())

    # Check if all letters of the alphabet are present
    return all(letter in sentence for letter in string.ascii_lowercase)

# Example usage for Roman numeral to integer conversion
roman_numeral = input("Enter a Roman numeral: ")
integer_value = roman_to_integer(roman_numeral.upper())
print("Integer value of", roman_numeral, "is", integer_value)

# Example usage for pangram check
input_sentence = input("Enter a sentence: ")
if is_pangram(input_sentence):
    print("The input is a pangram.")
else:
    print("The input is not a pangram.")
