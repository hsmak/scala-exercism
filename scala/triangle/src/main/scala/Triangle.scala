/**
 * The solution is based on:
 *  - Truth Table
 *  - Boolean Algebra
 *  - Boolean Expression Simplification
 *
 * @param s1
 * @param s2
 * @param s3
 */
case class Triangle(s1: Double, s2: Double, s3: Double) {

  private def isTriangle =
    if (s1 <= 0 || s2 <= 0 || s3 <= 0)
      false
    else {
      val (z :: x :: y :: Nil) = (s1 :: s2 :: s3 :: Nil).sorted.reverse
      z <= x + y
    }


  def equilateral =
    if (isTriangle)
      (s1 == s2, s1 == s3, s2 == s3) match {
        case (true, true, true) => true
        case _ => false
      }
    else
      false

  def isosceles =
    if (isTriangle)
      (s1 == s2, s1 == s3, s2 == s3) match {
        case (false, false, true) => true
        case (true, false, false) => true
        case (false, true, false) => true
        case (true, true, true) => true
        case _ => false
      }
    else
      false

  def scalene =
    if (isTriangle)
      (s1 == s2, s1 == s3, s2 == s3) match {
        case (false, false, false) => true
        case _ => false
      }
    else
      false

  /**
   * Another version, algebraic way and more succinct
   */
  object Algebraic {

    private val setOfSides = Set(s1, s2, s3)
    private val setSize = setOfSides.size

    val isTriangle = setOfSides.min > 0 && s1 + s2 > s3 && s1 + s3 > s2 && s2 + s3 > s1

    def equilateral = isTriangle && setSize == 1
    def isosceles = isTriangle && setSize <= 2
    def scalene = isTriangle && setSize == 3
  }
}