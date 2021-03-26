package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

func main() {
	r := setupRouter()
	r.Run(":8080")
}

func setupRouter() *gin.Engine {
	//r := gin.Default()
	r := gin.New()

	r.GET("/xkcvkak-no-use", func(c *gin.Context) {
		p := c.Params.ByName("p")
		p2 := p + p + p
		c.JSON(http.StatusOK, gin.H{"ping": p2})
	})
	r.GET("/bxkkasfa-no-use", func(c *gin.Context) {
		p := c.Params.ByName("p")
		p2 := p + p + p
		c.JSON(http.StatusOK, gin.H{"ping": p2})
	})
	r.GET("/bkskfaa-no-use", func(c *gin.Context) {
		p := c.Params.ByName("p")
		p2 := p + p + p
		c.JSON(http.StatusOK, gin.H{"ping": p2})
	})

	r.GET("/ping/:p", func(c *gin.Context) {
		p := c.Params.ByName("p")
		p2 := p + p + p
		c.String(http.StatusOK, p2)
	})

	return r
}
