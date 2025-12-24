#!/bin/bash
### BEGIN INIT INFO
# Provides: gpioinit
# Required-Start:
# Required-Stop:
# Default-Start:     S
# Default-Stop:
### END INIT INFO

GPIO_DIR=/sys/class/gpio

gpio_init () {
	if [ ! -d $GPIO_DIR/gpio$1 ]; then
		echo $1 > $GPIO_DIR/export
	fi

	echo out > $GPIO_DIR/gpio$1/direction
	echo 0 > $GPIO_DIR/gpio$1/value
}

gpio_set () {
	if [ -f $GPIO_DIR/gpio$1/value ]; then
		echo 1 > $GPIO_DIR/gpio$1/value
	fi
}

gpio_clear () {
	if [ -f $GPIO_DIR/gpio$1/value ]; then
		echo 0 > $GPIO_DIR/gpio$1/value
	fi
}

gpio_clear_all () {
	local l
	for l in "$@"; do
		gpio_clear $l
	done
}



LED_POWER=43
LED_LINK=91
LED_ACTIVITY=90
LED_BLUETOOTH=46

LED_ARRAY=($LED_POWER $LED_LINK $LED_ACTIVITY $LED_BLUETOOTH)

#RESET_HUB=13

main () {
	gpio_init $LED_POWER
	gpio_init $LED_LINK
	gpio_init $LED_ACTIVITY
	gpio_init $LED_BLUETOOTH

#	gpio_init $RESET_HUB
#	gpio_set $RESET_HUB

	gpio_set $LED_POWER
	gpio_set $LED_LINK
	gpio_set $LED_ACTIVITY
	gpio_set $LED_BLUETOOTH

	sleep 2

	gpio_clear_all "${LED_ARRAY[@]}"

	sleep 0.5

	SPEED=0.1
	for i in {0..3}; do
		for l in "${LED_ARRAY[@]}"; do
			gpio_clear_all "${LED_ARRAY[@]}"
			gpio_set "$l"
			sleep $SPEED
		done
	done

	gpio_clear_all "${LED_ARRAY[@]}"
}


main &
