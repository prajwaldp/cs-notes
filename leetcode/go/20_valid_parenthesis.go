package main

func isValid(s string) bool {
	stack := make([]rune, 0)

	for _, c := range s {
		if c == '(' || c == '{' || c == '[' {
			stack = append(stack, c)
		} else {
			if len(stack) == 0 {
				return false
			}

			switch c {
			case ')':
				if stack[len(stack)-1] == '(' {
					stack = stack[:len(stack)-1]
				} else {
					return false
				}
			case '}':
				if stack[len(stack)-1] == '{' {
					stack = stack[:len(stack)-1]
				} else {
					return false
				}
			case ']':
				if stack[len(stack)-1] == '[' {
					stack = stack[:len(stack)-1]
				} else {
					return false
				}
			}
		}
	}

	return len(stack) == 0
}
