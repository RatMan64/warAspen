import os
import platform
import sys

def main():
    # why im using platform.system() instead of a different way to check the platform
    # https://stackoverflow.com/questions/1854/python-what-os-am-i-running-on/58071295#58071295

    if len(sys.argv) < 3:
        print("not enough arguments, use: >python hp_env_setup.py siteflow_token siteflow_secret")
        return

    plat = platform.system()
    if plat == "Windows":
        set_env_cmd = "setx"
        cmd_sep = " "
    elif plat == "Linux":
        set_env_cmd = "export"
        cmd_sep = "="
    elif plat == "Darwin":
        raise NotImplementedError("i dont know how to set mac os environment variables sorry")
    else:
        raise OSError("unknown platform: " + plat)

    os.system(set_env_cmd + " AWS_ACCESS_KEY_ID"        + cmd_sep + sys.argv[1])
    os.system(set_env_cmd + " AWS_SECRET_ACCESS_KEY"       + cmd_sep + sys.argv[2])
    print("please restart any editors that need access to the new environment variables")

if __name__ == "__main__":
    main()
