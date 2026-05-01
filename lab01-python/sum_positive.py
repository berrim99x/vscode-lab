def sum_positive(numbers):
    if any(n < 0 for n in numbers):
        raise ValueError("List contains negative numbers!")
    return sum(numbers)