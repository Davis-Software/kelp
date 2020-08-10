package de.pxav.kelp.core.particle.effect;

import com.google.common.collect.Lists;
import de.pxav.kelp.core.logger.KelpLogger;
import de.pxav.kelp.core.logger.LogLevel;
import de.pxav.kelp.core.particle.type.ParticleType;
import de.pxav.kelp.core.player.KelpPlayer;
import org.bukkit.Location;

import java.util.Collection;
import java.util.List;

/**
 * A class description goes here.
 *
 * @author pxav
 */
public class ParticlePlainEffect extends ParticleEffect {

  private ParticleEffectRepository particleEffectRepository;
  private KelpLogger logger;

  private Location center;
  private List<Location> points;
  private ParticleType particleType;

  public ParticlePlainEffect(ParticleEffectRepository particleEffectRepository, KelpLogger logger) {
    this.particleEffectRepository = particleEffectRepository;
    this.logger = logger;
    this.points = Lists.newArrayList();
  }

  public ParticlePlainEffect particleType(ParticleType particleType) {
    this.particleType = particleType;
    return this;
  }

  public ParticlePlainEffect center(Location center) {
    this.center = center;
    return this;
  }

  public ParticlePlainEffect points(Location firstPoint, Location secondPoint) {
    this.points.clear();
    this.points.add(firstPoint);
    this.points.add(secondPoint);
    return this;
  }

  public ParticlePlainEffect points(Location firstPoint, Location secondPoint, Location thirdPoint, Location fourthPoint) {
    this.points.clear();
    this.points.add(firstPoint);
    this.points.add(secondPoint);
    this.points.add(thirdPoint);
    this.points.add(fourthPoint);
    return this;
  }

  @Override
  public void play(Collection<KelpPlayer> player) {

  }

  @Override
  public void play(KelpPlayer... player) {

  }

  private void playAnimationOnce(Collection<KelpPlayer> player) {
    if (points.isEmpty() && center != null) {
      // center based
    } else if (points.size() == 2) {
      Location firstPoint = points.get(0);
      Location secondPoint = points.get(1);

      if (firstPoint.getX() == secondPoint.getX()) {

      } else if (firstPoint.getY() == secondPoint.getY()) {

      } else {
        logger.log(LogLevel.ERROR, "The two points of a plain particle effect have to have at least one equal coordinate.");
      }

    }
  }

}
