from sum_positive import sum_positive
import pytest

def test_normal_numbers():
    assert sum_positive([1, 2, 3]) == 6

def test_empty_list():
    assert sum_positive([]) == 0

def test_single_number():
    assert sum_positive([5]) == 5

def test_negative_raises_exception():
    with pytest.raises(ValueError):
        sum_positive([1, -2, 3])

def test_all_negative_raises_exception():
    with pytest.raises(ValueError):
        sum_positive([-1, -2, -3])