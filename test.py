def is_pangram(my_str):
    letters_seen = set()
    alphabet = set('abcdefghijklmnopqrstuvwxyz')
    for item in my_str:
        if item.isalpha():
            letters_seen.add(item.lower())

    return alphabet.issubset(letters_seen)
         




one = 'koajshndkahjndwkja'
two = 'abcdefghijklmnopqrstuvwxyz'

print(is_pangram(one))
print(is_pangram(two))