Commands:

/gym - Lists the status of each gym (open/close)
/gym <gym name> - Lists the status of the specified gym
/gym list <gym name> - Lists the leaders of that gym
/leader list <gym name> - Same as above, people couldn't read the instructions -.-
/leader add <gym name> <player name> - Adds the player to the specified gym
/leader del <gym name> <player name> - Removes the player from the specified gym
/leader givebadge <player name> <badge name / id> - Gives the player the badge (Can handle strings or ints)


TODO:


== Config ==
- Add a users folder to the leaders folder that contains a "{USERNAME}.yml" file for each user
    - Users file should have:
      - Username
      - Badges (int? array?)
      - Leader status (???)
    
- Add a gym file in the leader folders called "gyms.yml"
    - Gym file should have:
      - Gym name (eg: water)
      - Gym status (eg: open)
      - Gym color (eg: BLUE)
      - Gym leaders (eg: Ryalane) :D
      
      - Gym types (Array of Strings for each gym name) (eg: Water, Electric, Grass...)
      
- Add a config.yml file (already there) and have it hold settings instead of gyms
    - Config file should contain all the settings (not even implemented so work on it last)

== Appearance ==
- Add leader prefix if everything else is done

== Functionality ==
- Add region functions
