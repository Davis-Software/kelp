package de.pxav.kelp.core.test.animation;

import de.pxav.kelp.core.animation.BuildingTextAnimation;
import de.pxav.kelp.core.common.StringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * A class description goes here.
 *
 * @author pxav
 */
public class BuildingTextAnimationTest {

  private BuildingTextAnimation textAnimation;
  private StringUtils stringUtils;

  @Before
  public void setTextAnimation() {
    this.stringUtils = new StringUtils();
    this.textAnimation = new BuildingTextAnimation(stringUtils);
  }

  @Test
  public void testDefaultCase() {
    textAnimation.text("Hello World!");

  }

}
