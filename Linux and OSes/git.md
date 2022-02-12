## If you ever need to squash commits on one branch that has already been pushed to remote, do:

 Squash commits locally with

```
git rebase -i origin/master~4 master
```

Leave the first commit as 'pick', the others change to squash

and then force push with

```
git push origin +master
```

------

### Difference between `--force` and `+`

From the documentation of [`git push`](https://git-scm.com/docs/git-push#Documentation/git-push.txt---force):

> Note that `--force` applies to all the refs that are pushed, hence using it with `push.default` set to `matching` or with multiple push destinations configured with `remote.*.push` may overwrite refs other than the current branch (including local refs that are strictly behind their remote counterpart). To force a push to only one branch, use a `+` in front of the refspec to push (e.g `git push origin +master` to force a push to the `master` branch).

From https://stackoverflow.com/questions/5667884/how-to-squash-commits-in-git-after-they-have-been-pushed

