import (
	"fmt"
	"strings"
)

func movesToStamp(stamp string, target string) []int {
	if stamp == target {
		return make([]int, 1)
	}

	var ans []int
	sList := strings.Split(stamp, "")
	tList := strings.Split(target, "")

	sLen := len(sList)
	tLen := len(tList) - sLen + 1

	tDiff := true
	sDiff := true

	var j int

	for tDiff {
		tDiff = false
		for i := 0; i < tLen; i++ {
			sDiff = false
			for j = 0; j < sLen; j++ {
				if tList[i+j] == "*" {
					continue
				} else if tList[i+j] != sList[j] {
					break
				} else {
					sDiff = true
				}
			}
			if j == sLen && sDiff {
				tDiff = true
				for j = i; j < i+sLen; j++ {
					tList[j] = "*"
				}
				ans = append(ans, i)
			}
		}
	}

	for i := 0; i < len(tList); i++ {
		if tList[i] != "*" {
			return make([]int, 0)
		}
	}

	for a, b := 0, len(ans)-1; a < b; a, b = a+1, b-1 {
		ans[a], ans[b] = ans[b], ans[a]
	}

	return ans
}
