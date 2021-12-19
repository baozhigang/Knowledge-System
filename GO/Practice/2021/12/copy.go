package main

import (
	"io"
	"os"
)

func main() {
	CopyFile("1.php", "checkColor.php")
}

func CopyFile(dst, src string) (w int64, err error) {
	srcFile, err := os.Open(src)
	if err != nil {
		return
	}

	defer srcFile.Close()
	dstFile, err := os.Create(dst)
	if err != nil {
		return
	}

	defer dstFile.Close()
	return io.Copy(dstFile, srcFile)
}
