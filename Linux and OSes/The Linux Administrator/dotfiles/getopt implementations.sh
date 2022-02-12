# https://code-maven.com/bash-getopt-processing-command-line-arguments
function args()
{
    options=$(getopt -o dv --long debug --long name: -- "$@")
    [ $? -eq 0 ] || {
        echo "Incorrect option provided"
        exit 1
    }
    eval set -- "$options"
    while true; do
        case "$1" in
        -v)
            VERBOSE=1
            ;;
        -d)
            DEBUG=1
            ;;
        --debug)
            DEBUG=1
            ;;
        --name)
            shift; # The arg is next in position args
            NAME=$1
            ;;
        --)
            shift
            break
            ;;
        esac
        shift
    done
}
 
args $0 "$@"    


# https://dustymabe.com/2013/05/17/easy-getopt-for-a-bash-script/
# Call getopt to validate the provided input. 
options=$(getopt -o brg --long color: -- "$@")
[ $? -eq 0 ] || { 
    echo "Incorrect options provided"
    exit 1
}
eval set -- "$options"
while true; do
    case "$1" in
    -b)
        COLOR=BLUE
        ;;
    -r)
        COLOR=RED
        ;;
    -g)
        COLOR=GREEN
        ;;
    --color)
        shift; # The arg is next in position args
        COLOR=$1
        [[ ! $COLOR =~ BLUE|RED|GREEN ]] && {
            echo "Incorrect options provided"
            exit 1
        }
        ;;
    --)
        shift
        break
        ;;
    esac
    shift
done

echo "Color is $COLOR"
exit 0;


# https://stackoverflow.com/a/33826763
#!/bin/bash
# More safety, by turning some bugs into errors.
# Without `errexit` you don’t need ! and can replace
# PIPESTATUS with a simple $?, but I don’t do that.
set -o errexit -o pipefail -o noclobber -o nounset

# -allow a command to fail with !’s side effect on errexit
# -use return value from ${PIPESTATUS[0]}, because ! hosed $?
! getopt --test > /dev/null 
if [[ ${PIPESTATUS[0]} -ne 4 ]]; then
    echo 'I’m sorry, `getopt --test` failed in this environment.'
    exit 1
fi

OPTIONS=dfo:v
LONGOPTS=debug,force,output:,verbose

# -regarding ! and PIPESTATUS see above
# -temporarily store output to be able to check for errors
# -activate quoting/enhanced mode (e.g. by writing out “--options”)
# -pass arguments only via   -- "$@"   to separate them correctly
! PARSED=$(getopt --options=$OPTIONS --longoptions=$LONGOPTS --name "$0" -- "$@")
if [[ ${PIPESTATUS[0]} -ne 0 ]]; then
    # e.g. return value is 1
    #  then getopt has complained about wrong arguments to stdout
    exit 2
fi
# read getopt’s output this way to handle the quoting right:
eval set -- "$PARSED"

d=n f=n v=n outFile=-
# now enjoy the options in order and nicely split until we see --
while true; do
    case "$1" in
        -d|--debug)
            d=y
            shift
            ;;
        -f|--force)
            f=y
            shift
            ;;
        -v|--verbose)
            v=y
            shift
            ;;
        -o|--output)
            outFile="$2"
            shift 2
            ;;
        --)
            shift
            break
            ;;
        *)
            echo "Programming error"
            exit 3
            ;;
    esac
done

# handle non-option arguments
if [[ $# -ne 1 ]]; then
    echo "$0: A single input file is required."
    exit 4
fi


# https://stackoverflow.com/questions/41651529/how-to-use-getopt-with-long-options-in-bash
#!/bin/bash
# *** Make sure you have a new enough getopt to handle long options (see the man page)
getopt -T &>/dev/null
if [[ $? -ne 4 ]]; then echo "Getopt is too old!" >&2 ; exit 1 ; fi

declare {BPM_USERNAME,BPM_PASSWORD,HOST,TARGET_IP,OVERRIDE_STATUS}=''
OPTS=$(getopt -o '' -a --longoptions 'username:,password:,csc:,ip:,override:' -n "$0" -- "$@")
    # *** Added -o '' ; surrounted the longoptions by ''
if [[ $? -ne 0 ]] ; then echo "Failed parsing options." >&2 ; exit 1 ; fi
    # *** This has to be right after the OPTS= assignment or $? will be overwritten

set -- $OPTS
    # *** As suggested by chepner

while true; do
    # ... no changes in the while loop
done
