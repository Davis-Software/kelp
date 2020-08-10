package de.pxav.kelp.core.particle.effect.animation;

import de.pxav.kelp.core.particle.effect.ParticleEffect;
import de.pxav.kelp.core.player.KelpPlayer;
import org.bukkit.Location;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * A class description goes here.
 *
 * @author pxav
 */
public class MovingParticleAnimation {

  private ParticleEffect particleEffect;
  private ConcurrentHashMap<Location, Integer> points; // point location -> time in millis to get to the location
  private Executors executors;

  public MovingParticleAnimation() {

  }

  public MovingParticleAnimation particleEffect(ParticleEffect particleEffect) {
    this.particleEffect = particleEffect;
    return this;
  }

  public MovingParticleAnimation addPoint(Location location, Integer timeInMillis) {
    this.points.put(location, timeInMillis);
    return this;
  }

  public void playAnimation(KelpPlayer player) {
    for (Map.Entry<Location, Integer> entry : points.entrySet()) {

      // should animation happen instantly?
      if (entry.getValue() == 0) {

      }

    }
    ScheduledExecutorService executorService;

  }



}
